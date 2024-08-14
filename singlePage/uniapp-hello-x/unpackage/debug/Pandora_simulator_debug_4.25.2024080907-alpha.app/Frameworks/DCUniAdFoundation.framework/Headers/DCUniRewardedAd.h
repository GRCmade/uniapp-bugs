//
//  DCUniRewardedAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "DCUniServerSideVerificationOptions.h"
NS_ASSUME_NONNULL_BEGIN
@class DCUniRewardedAd;
@protocol DCRewardVideoAdDelegate <NSObject>
/// 广告加载完成
/// @param rewardVideoAd 加载对象
- (void)rewardVideoAdDidLoad:(DCUniRewardedAd *)rewardVideoAd;

/// 广告关闭
/// @param rewardVideoAd 加载对象
- (void)rewardVideoAdDidClose:(DCUniRewardedAd *)rewardVideoAd;

/// 广告加载出错
/// @param rewardVideoAd 加载对象
/// @param error 错误信息
- (void)rewardedVideoAd:(DCUniRewardedAd *)rewardVideoAd didFailWithError:(NSError *)error;

/// 广告播放完毕
/// @param rewardVideoAd 加载对象
/// @param error 错误信息
- (void)rewardVideoAdDidPlayFinish:(DCUniRewardedAd *)rewardVideoAd didFailWithError:(NSError *_Nullable)error;

/// 广告展示完毕
/// @param rewardVideoAd 加载对象
- (void)rewardedVideoAdDidVisible:(DCUniRewardedAd *)rewardVideoAd;

/// 广告被点击
/// @param rewardVideoAd 加载对象
- (void)rewardVideoAdDidClicked:(DCUniRewardedAd *)rewardVideoAd;


/// 奖励回调
/// @param rewardVideoAd 加载对象
- (void)rewardedVideoAdServerReward:(DCUniRewardedAd *)rewardVideoAd info:(NSDictionary *)info;

@end

@interface DCUniRewardedAd : NSObject

/// 初始化激励视频
/// @param adpid 广告位标识
/// @param delegate 处理回调方法的代理对象
- (instancetype)initWithAdpid:(NSString *)adpid
                  andDelegate:(id<DCRewardVideoAdDelegate>)delegate;

/// 初始化激励视频
/// @param adpid 广告位标识
/// @param options 激励视频服务器回调数据
/// @param delegate 处理回调方法的代理对象
- (instancetype)initWithAdpid:(NSString *)adpid
serverSideVerificationOptions:(DCUniServerSideVerificationOptions * __nullable)options
                  andDelegate:(id<DCRewardVideoAdDelegate>)delegate;

/// 加载广告数据
- (void)loadAdData;

/// 显示广告
/// @param rootViewController 用于展示激励视频广告的 rootViewController
- (void)showRewardVideoAdFromRootViewController:(UIViewController *)rootViewController;

@end

NS_ASSUME_NONNULL_END
