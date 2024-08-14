import DCloudUTSFoundation;
import DCloudUniappRuntime;
public typealias OpenSchema = (_ url: String) -> Void;
public var openSchema: OpenSchema = {
(_ url: String) -> Void in
if (UTSiOS.typeof( url) == "string" && url.length > 0) {
    var uri = URL(string: url);
    if (uri != nil && UIApplication.shared.canOpenURL(uri!)) {
        UIApplication.shared.open(uri!, options: Map<UIApplication.OpenExternalURLOptionsKey, Any>(), completionHandler: nil);
    } else {
        console.error("url param Error: ", url, " at uni_modules/uts-openSchema/utssdk/app-ios/index.uts:9");
    }
} else {
    console.error("url param Error: ", url, " at uni_modules/uts-openSchema/utssdk/app-ios/index.uts:12");
}
};
public func openSchemaByJs(_ url: String) -> Void {
    return openSchema(url);
}
@objc(UTSSDKModulesUtsOpenSchemaIndexSwift)
@objcMembers
public class UTSSDKModulesUtsOpenSchemaIndexSwift : NSObject {
    public static func s_openSchemaByJs(_ url: String) -> Void {
        return openSchemaByJs(url);
    }
}
