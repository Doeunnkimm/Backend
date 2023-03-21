function testLet() {
    let data = 10;
    // let data = 20; // SyntaxError: Identifier 'data' has already been declared
    data = 20;
}
testLet();

const ON = 1;
function testConst() {
    // ON = 2;
    console.log(ON);
}
testConst();