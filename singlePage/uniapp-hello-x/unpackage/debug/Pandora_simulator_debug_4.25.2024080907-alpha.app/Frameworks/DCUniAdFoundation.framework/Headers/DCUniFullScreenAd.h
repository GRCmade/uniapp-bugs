//
//  DCUniFullScreenAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
NS_ASSUME_NONNULL_BEGIN
@class DCUniFullScreenAd;
@protocol DCFullScreenVideoAdDelegate <NSObject>
/// 广告加载完成
/// @param fullScreenAd 加载对象
- (void)fullScreenVideoAdDidLoad:(DCUniFullScreenAd *)fullScreenAd;


/// 广告关闭
/// @param fullScreenAd 加载对象
- (void)fullScreenVideoAdDidClose:(DCUniFullScreenAd *)fullScreenAd;


/// 广告加载出错
/// @param fullScreenAd 加载对象
/// @param error 错误信息
- (void)fullScreenVideoAd:(DCUniFullScreenAd *)fullScreenAd didFailWithError:(NSError *_Nullable)error;


/// 广告播放完毕
/// @param fullScreenAd 加载对象
/// @param error 错误信息
- (void)fullScreenVideoAdDidPlayFinish:(DCUniFullScreenAd *)fullScreenAd didFailWithError:(NSError *_Nullable)error;


/// 广告被点击
/// @param fullScreenAd 加载对象
- (void)fullScreenVideoAdDidClicked:(DCUniFullScreenAd *)fullScreenAd;

/// 广告展示完毕
/// @param fullScreenAd 加载对象
- (void)fullScreenVideoAdDidVisible:(DCUniFullScreenAd *)fullScreenAd;
@end

@interface DCUniFullScreenAd : NSObject

/// 初始化全屏视频广告
/// @param adpid 广告位标识
/// @param delegate 处理回调方法的代理对象
- (instancetype)initWithAdpid:(NSString *)adpid
                  andDelegate:(id<DCFullScreenVideoAdDelegate>)delegate;

/// 加载广告数据
- (void)loadAdData;

/// 显示广告
/// @param rootViewController 用于展示全屏视频广告的 rootViewController
- (void)showFullScreenVideoAdFromRootViewController:(UIViewController *)rootViewController;
@end

NS_ASSUME_NONNULL_END
