//
//  DCUniSplashAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
NS_ASSUME_NONNULL_BEGIN
@class DCUniSplashAd;
@protocol DCSplashAdDelegate <NSObject>
/// 开屏广告加载完成
/// @param splashAd 加载对象
- (void)splashAdDidLoad:(DCUniSplashAd *)splashAd;

/// 开屏广告关闭
/// @param splashAd 加载对象
- (void)splashAdDidClose:(DCUniSplashAd *)splashAd;

/// 开屏广告被点击
/// @param splashAd 加载对象
- (void)splashAdDidClick:(DCUniSplashAd *)splashAd;

/// 开屏广告将要显示
/// @param splashAd 加载对象
- (void)splashAdDidVisible:(DCUniSplashAd *)splashAd;

/// 广告加载失败
/// @param splashAd 加载对象
/// @param error 错误信息
- (void)splashAd:(DCUniSplashAd *)splashAd didFailWithError:(NSError *)error;

/// 广告展示失败
/// @param error 错误信息
- (void)splashAdShowFail:(DCUniSplashAd *)splashAd error:(NSError *)error;
@end

@interface DCUniSplashAd : NSObject

/// 初始化开屏广告
/// @param containerView  广告内容视图
/// @param bottomView 广告底部视图
/// @param delegate 广告代理
+ (void)showInView:(UIView *)containerView withBottomView:(nullable UIView *)bottomView andDelegate:(id<DCSplashAdDelegate>)delegate;

@end

NS_ASSUME_NONNULL_END