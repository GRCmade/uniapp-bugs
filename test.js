(function(factory){
  console.log("1",typeof define === "function" && define.amd ? define(factory) : factory())
})(function(){
  console.log("2")
})
