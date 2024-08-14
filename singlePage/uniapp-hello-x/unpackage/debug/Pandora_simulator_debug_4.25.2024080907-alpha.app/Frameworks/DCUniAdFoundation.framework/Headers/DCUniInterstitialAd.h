//
//  DCUniInterstitialAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
NS_ASSUME_NONNULL_BEGIN
@class DCUniInterstitialAd;
@protocol DCInterstitialVideoAdDelegate <NSObject>

/// 广告加载完成
/// @param interstitialAd  加载对象
- (void)interstitialAdDidLoad:(DCUniInterstitialAd *)interstitialAd;

/// 广告关闭
/// @param interstitialAd 加载对象
- (void)interstitialAdDidClose:(DCUniInterstitialAd *)interstitialAd;
///  广告加载出错
/// @param interstitialAd 加载对象
/// @param error 错误信息
- (void)interstitialAd:(DCUniInterstitialAd *)interstitialAd didFailWithError:(NSError *_Nullable)error;

/// 广告播放完毕
/// @param interstitialAd 加载对象
/// @param error 错误信息
- (void)interstitialAdDidPlayFinish:(DCUniInterstitialAd *)interstitialAd didFailWithError:(NSError *_Nullable)error;

/// 广告被点击
/// @param interstitialAd 加载对象
- (void)interstitialAdDidClicked:(DCUniInterstitialAd *)interstitialAd;

/// 广告展示完毕
/// @param interstitialAd 加载对象
- (void)interstitialAdDidVisible:(DCUniInterstitialAd *)interstitialAd;

/// 广告渲染失败
/// @param interstitialAd 加载对象
/// @param error 错误信息
- (void)interstitialAdRenderFail:(DCUniInterstitialAd *)interstitialAd error:(NSError *_Nullable)error;

@end
@interface DCUniInterstitialAd : NSObject

/// 初始化插屏视频广告
/// @param adpid 广告位标识
/// @param delegate 处理回调方法的代理对象
- (instancetype)initWithAdpid:(NSString *)adpid
                  andDelegate:(id<DCInterstitialVideoAdDelegate>)delegate;

/// 加载广告数据
- (void)loadAdData;

/// 显示广告
/// @param rootViewController 用于展示插屏视频广告的 rootViewController
- (void)showInterstitialVideoAdFromRootViewController:(UIViewController *)rootViewController;
@end

NS_ASSUME_NONNULL_END
