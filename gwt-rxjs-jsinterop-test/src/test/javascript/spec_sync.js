/* global syncTests, expect, describe, beforeEach, it */

describe("Synchronous specs", function () {

    /**
     * Wait for GWT module to be loaded
     */
    beforeEach(function (done) {
        var await = function () {
            if (!!syncTests) {
                done();
            } else {
                setTimeout(await, 200);
            }
        };
        setTimeout(await, 200);
    });

    it("must start synchronous tests execution", function (done) {
        describe("Observable", function () {
            for (var prop in syncTests) {
                if (prop.indexOf("test") != -1) {
                    it("must provide \'" + prop.replace("test", "").toLowerCase() + "\'", function () {
                        expect(syncTests[prop]()).toBeTruthy();
                    })
                }
            }
        });
        expect(true).toBeTruthy();
        done();
    });
});
