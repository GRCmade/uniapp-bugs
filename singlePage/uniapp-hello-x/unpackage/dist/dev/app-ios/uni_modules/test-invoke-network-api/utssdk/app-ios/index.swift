import DCloudUTSFoundation;
import DCloudUniappRuntime;
import DCloudUTSExtAPI;
@objc(UTSSDKModulesTestInvokeNetworkApiCommonOptions)
@objcMembers
public class CommonOptions : NSObject, UTSObject, IUTSSourceMap {
    public func __$getOriginalPosition() -> UTSSourceMapPosition? {
        return UTSSourceMapPosition("CommonOptions", "uni_modules/test-invoke-network-api/utssdk/interface.uts", 2, 13);
    }
    public var success: ((_ res: Any) -> Void)?;
    public var fail: ((_ res: Any) -> Void)?;
    public subscript(_ key: String) -> Any? {
        get {
            return utsSubscriptGetValue(key);
        }
        set {
            switch(key){
                case "success":
                    self.success = try! utsSubscriptCheckValueIfPresent(newValue);
                case "fail":
                    self.fail = try! utsSubscriptCheckValueIfPresent(newValue);
                default:
                    break;
            }
        }
    }
    public override init() {
        super.init();
    }
    public init(_ obj: UTSJSONObject) {
        self.success = obj["success"] as! ((_ res: Any) -> Void)?;
        self.fail = obj["fail"] as! ((_ res: Any) -> Void)?;
    }
}
public func testInovkeRequest(_ options: CommonOptions) -> Void {
    DCloudUTSExtAPI.request(RequestOptions<Any>(UTSJSONObject([
        "url": "https://request.dcloud.net.cn/api/http/method/post",
        "method": "POST",
        "header": UTSJSONObject([
            "Cookie": "token11222"
        ]),
        "timeout": 6000 as NSNumber,
        "sslVerify": false,
        "withCredentials": false,
        "data": UTSJSONObject([
            "platform": UTSJSONObject([
                "abc": "xyq"
            ])
        ]),
        "firstIpv4": false,
        "success": {
        (res: RequestSuccess<Any>) -> Void in
        options.success?(res);
        },
        "fail": {
        (_ e: RequestFail) -> Void in
        options.fail?(e);
        }
    ])), Any.self);
}
public func testInovkeUploadFile(_ options: CommonOptions) -> Void {
    var imageSrc = "/static/uni.png";
    DCloudUTSExtAPI.uploadFile(UploadFileOptions(UTSJSONObject([
        "url": "https://unidemo.dcloud.net.cn/upload",
        "files": [
            UploadFileOptionFiles(UTSJSONObject([
                "name": "file1",
                "uri": imageSrc
            ])),
            UploadFileOptionFiles(UTSJSONObject([
                "name": "file2",
                "uri": imageSrc
            ]))
        ],
        "success": {
        (res: UploadFileSuccess) -> Void in
        options.success?(res);
        },
        "fail": {
        (err: UploadFileFail) -> Void in
        options.fail?(err);
        }
    ])));
}
public func testInovkeDownloadFile(_ options: CommonOptions) -> Void {
    DCloudUTSExtAPI.downloadFile(DownloadFileOptions(UTSJSONObject([
        "url": "https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/uni-app.png",
        "filePath": """
\(DCloudUTSFoundation.env.CACHE_PATH)/halo/world/
""",
        "success": {
        (_ res: DownloadFileSuccess) -> Void in
        options.success?(res);
        },
        "fail": {
        (_ e: DownloadFileFail) -> Void in
        options.fail?(e);
        }
    ])));
}
@objc(UTSSDKModulesTestInvokeNetworkApiCommonOptionsJSONObject)
@objcMembers
public class CommonOptionsJSONObject : NSObject {
    public var success: UTSCallback?;
    public var fail: UTSCallback?;
}
public func testInovkeRequestByJs(_ options: CommonOptionsJSONObject) -> Void {
    return testInovkeRequest(CommonOptions(UTSJSONObject([
        "success": {
        (res: Any) -> Void in
        options.success?(res);
        },
        "fail": {
        (res: Any) -> Void in
        options.fail?(res);
        }
    ])));
}
public func testInovkeUploadFileByJs(_ options: CommonOptionsJSONObject) -> Void {
    return testInovkeUploadFile(CommonOptions(UTSJSONObject([
        "success": {
        (res: Any) -> Void in
        options.success?(res);
        },
        "fail": {
        (res: Any) -> Void in
        options.fail?(res);
        }
    ])));
}
public func testInovkeDownloadFileByJs(_ options: CommonOptionsJSONObject) -> Void {
    return testInovkeDownloadFile(CommonOptions(UTSJSONObject([
        "success": {
        (res: Any) -> Void in
        options.success?(res);
        },
        "fail": {
        (res: Any) -> Void in
        options.fail?(res);
        }
    ])));
}
@objc(UTSSDKModulesTestInvokeNetworkApiIndexSwift)
@objcMembers
public class UTSSDKModulesTestInvokeNetworkApiIndexSwift : NSObject {
    public static func s_testInovkeRequestByJs(_ options: CommonOptionsJSONObject) -> Void {
        return testInovkeRequestByJs(options);
    }
    public static func s_testInovkeUploadFileByJs(_ options: CommonOptionsJSONObject) -> Void {
        return testInovkeUploadFileByJs(options);
    }
    public static func s_testInovkeDownloadFileByJs(_ options: CommonOptionsJSONObject) -> Void {
        return testInovkeDownloadFileByJs(options);
    }
}
