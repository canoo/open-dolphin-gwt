define(["require", "exports", "dolphin/Codec"], function(require, exports, cod) {
	(function (dolphin) {
		var HttpTransmitter = (function () {
			function HttpTransmitter(url, reset) {
				if (typeof reset === "undefined") { reset = true; }
				this.url = url;
				this.HttpCodes = {
					finished: 4,
					success: 200
				};
				this.http = new XMLHttpRequest();

				//            this.http.withCredentials = true; // not supported in all browsers
				this.codec = new cod.dolphin.Codec();
				if (reset) {
					this.invalidate();
				}
			}
			HttpTransmitter.prototype.transmit = function (commands, onDone) {
				var _this = this;
				this.http.onerror = function (evt) {
					alert("could not fetch " + _this.url + ", message: " + evt.message); // todo dk: make this injectable
					onDone([]);
				};

				this.http.onreadystatechange = function (evt) {
					if (_this.http.readyState == _this.HttpCodes.finished) {
						if (_this.http.status == _this.HttpCodes.success) {
							var responseText = _this.http.responseText;
							var responseCommands = _this.codec.decode(responseText);
							onDone(responseCommands);
						}
						//todo ks: if status is not 200 then show error
					}
				};

				this.http.open('POST', this.url, true);
				this.http.send(this.codec.encode(commands));
			};

			HttpTransmitter.prototype.signal = function (command) {
				var sig = new XMLHttpRequest();
				sig.open('POST', this.url, true);
				sig.send(this.codec.encode([command]));
			};

			HttpTransmitter.prototype.invalidate = function () {
				this.http.open('POST', this.url + 'invalidate?', false);
				this.http.send();
			};
			return HttpTransmitter;
		})();
		dolphin.HttpTransmitter = HttpTransmitter;
	})(exports.dolphin || (exports.dolphin = {}));
	var dolphin = exports.dolphin;
});
