let statusList_1 = ["3","38","43","45","98","102","183","686","872","884","1811","1999","6462","6789","7993","9711","13879","13891","14618","14811","15021","15504","16150","17385","17984","21588"]


let statusList_6 = ["2546","2574","2583","2584","2585","2586","2587","2588","2651","2671","2672","2717","3851","4117","11700"]

let statusAll = [...statusList_1, ...statusList_6]

let base = {
  "uni-app": {
    "ios":"y",
    "android":"y",
    "harmony":"y"
  }
}
/**
 * 预期数据格式：
 * {
    "2546": {
        "uni-app": {
            "ios":"y",
            "android":"y",
            "harmony":"y"
        },
        "uni-app-x": {
            "ios": "y",
            "android": "y"
        }
    }
}
 */

let res = statusAll.reduce((acc, status) => {
  acc[status] = base;
  return acc;
}, {});


console.log(JSON.stringify(res, null, 2));
