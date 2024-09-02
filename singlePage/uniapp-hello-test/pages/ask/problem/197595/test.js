function Init(){
// #ifdef APP-PLUS
console.log('app');
// #endif
// #ifndef APP-PLUS
console.log('H5');
// #endif
}
export default {
Init: Init
}