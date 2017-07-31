/* global testsContainer, expect */

describe("Observable creation", function() {
    // wait while GWT module is being loaded
    beforeEach(function (done) {
        var check = function () {
            if (!!testsContainer) {
                done();
            } else {
                setTimeout(check, 200);
            }
        };
        setTimeout(check, 200);
    });

    it("must provide \"subscribers\"", function (done) {
        expect(testsContainer.subscribers()).toBeTruthy();
        done();
    });

    it("must provide \"create\"", function (done) {
        expect(testsContainer.create()).toBeTruthy();
        done();
    });

    it("must provide subscription with \"add\" operation", function (done) {
        expect(testsContainer.createWithAdditionalSubscription()).toBeTruthy();
        done();
    });

    it("must provide \"of\"", function (done) {
        expect(testsContainer.of()).toBeTruthy();
        done();
    });

    it("must provide \"from\"", function (done) {
        expect(testsContainer.from()).toBe("7");
        done();
    });

});
describe("Observable operators", function () {

    it("must provide \"defer\"", function (done) {
        expect(testsContainer.defer()).toBe("1");
        done();
    });

    it("must provide \"empty\"", function (done) {
        expect(testsContainer.empty()).toBe("11");
        done();
    });

    it("must provide \"if\" then", function (done) {
        expect(testsContainer.ifThen()).toBeTruthy();
        done();
    });

    it("must provide \"if\" else", function (done) {
        expect(testsContainer.ifElse()).toBeFalsy();
        done();
    });

    it("must provide \"map\"", function (done) {
        expect(testsContainer.map()).toBeFalsy();
        done();
    });

    it("must provide \"filter\"", function (done) {
        expect(testsContainer.filter()).toBeFalsy();
        done();
    });

    it("must provide \"filterPredicate\"", function (done) {
        expect(testsContainer.filterPredicate()).toBeFalsy();
        done();
    });

    it("must provide merging of two", function (done) {
        expect(testsContainer.mergeTwo()).toBe("12");
        done();
    });

    it("must provide merging of three", function (done) {
        expect(testsContainer.mergeThree()).toBe("123");
        done();
    });

    it("must provide racing", function (done) {
        expect(testsContainer.race()).toBe("1");
        done();
    });

    it("must provide \"do\" side effects", function (done) {
        expect(testsContainer.do()).toBe("1");
        done();
    });

    it("must provide \"elementAt\"", function (done) {
        expect(testsContainer.elementAt()).toBe("3");
        done();
    });

    it("must provide \"elementAtDefault\"", function (done) {
        expect(testsContainer.elementAtDefault()).toBe("-1");
        done();
    });

    it("must provide \"every\"", function (done) {
        expect(testsContainer.every()).toBeTruthy();
        done();
    });

    it("must provide \"exhaust\"", function (done) {
        expect(testsContainer.exhaust()).toBe("123");
        done();
    });

    it("must provide \"exhaustMap\"", function (done) {
        expect(testsContainer.exhaustMap()).toBe("102030");
        done();
    });

    it("must provide \"take\"", function (done) {
        expect(testsContainer.take()).toBe("12");
        done();
    });

    it("must provide \"expand\"", function (done) {
        expect(testsContainer.expand()).toBe("110100");
        done();
    });

    it("must provide \"finally\"", function (done) {
        expect(testsContainer.finally()).toBe("finally");
        done();
    });

    it("must provide \"find\"", function (done) {
        expect(testsContainer.find()).toBe("1");
        done();
    });

    it("must provide \"findIndex\"", function (done) {
        expect(testsContainer.findIndex()).toBe("1");
        done();
    });

    it("must provide \"first\"", function (done) {
        expect(testsContainer.first()).toBe("2");
        done();
    });

    it("must provide \"groupBy\"", function (done) {
        expect(testsContainer.groupBy()).toBe("312");
        done();
    });

    it("must provide \"ignoreElements\"", function (done) {
        expect(testsContainer.ignoreElements()).toBe("");
        done();
    });

    it("must provide \"last\"", function (done) {
        expect(testsContainer.last()).toBe("1");
        done();
    });

    it("must provide \"mapTo\"", function (done) {
        expect(testsContainer.mapTo()).toBe("55555");
        done();
    });

    it("must provide \"max\"", function (done) {
        expect(testsContainer.max()).toBe("8");
        done();
    });

    it("must provide \"maxComparer\"", function (done) {
        expect(testsContainer.maxComparer()).toBe("12");
        done();
    });

    it("must provide \"mergeAll\"", function (done) {
        expect(testsContainer.mergeAll()).toBe("13");
        done();
    });

    it("must provide \"pairwise\"", function (done) {
        expect(testsContainer.pairwise()).toBe("13");
        done();
    });

    it("must provide \"partition\"", function (done) {
        expect(testsContainer.partition()).toBe("1");
        done();
    });

    it("must provide \"range\"", function (done) {
        expect(testsContainer.range()).toBe("123");
        done();
    });

    it("must provide \"throw\"", function (done) {
        expect(testsContainer.throw()).toBe("1");
        done();
    });
});

describe("Schedulers", function () {
    beforeEach(function (done) {
        testsContainer.asyncScheduler(function() {
            done();
        });
    });
    it("must provide \"async\" scheduler", function (done) {
        expect(true).toBe(true);
        done();
    });

});

describe("Interval operator", function() {
    beforeEach(function (done) {
        testsContainer.interval(function() {
            done();
        });
    });
    it("must provide \"interval\"", function (done) {
        expect(true).toBe(true);
        done();
    });
});