/* global generatedTests, expect, describe, beforeEach, it */

describe("Generated declarations tests executor", function () {

    /**
     * Wait for GWT module to be loaded
     */
    beforeEach(function (done) {
        var await = function () {
            if (!!generatedTests) {
                done();
            } else {
                setTimeout(await, 200);
            }
        };
        setTimeout(await, 200);
    });

    it("must start generated tests execution", function (done) {
        describe("Observable", function () {
            for (var prop in generatedTests) {
                it("must provide \'" + prop.replace("test", "").toLowerCase() + "\'", function () {
                    expect(generatedTests[prop]()).toBeTruthy();
                });
            }
        });
        done();
    });
});
