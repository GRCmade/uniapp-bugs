//
//  DCUniDrawFeedAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "DCUniDrawFeedAdDataObject.h"
@class DCUniDrawFeedAd;
NS_ASSUME_NONNULL_BEGIN

@protocol DCDrawFeedAdDelegate <NSObject>
/// 广告加载完成
/// @param drawFeedAd  当前加载对象
/// @param dataObjects 所有广告内容数组
- (void)drawFeedAdSuccessToLoad:(DCUniDrawFeedAd *)drawFeedAd data:(NSArray<DCUniDrawFeedAdDataObject *> *)dataObjects;


/// 广告加载失败
/// @param error 错误信息
- (void)drawFeedAdFailToLoad:(NSError *)error;

/// 广告关闭
/// @param object 广告信息
- (void)drawFeedAdDidClose:(DCUniDrawFeedAdDataObject *)object;


/// 广告被点击
/// @param object 广告信息
- (void)drawFeedAdDidClick:(DCUniDrawFeedAdDataObject *)object;

/// 广告将要展示
/// @param object 广告信息
- (void)drawFeedAdWillShow:(DCUniDrawFeedAdDataObject *)object;

/// 广告dislake
/// @param object 广告对象
- (void)drawFeedAdDislike:(DCUniDrawFeedAdDataObject *)object reason:(NSDictionary *)reason;

/// 广告渲染成功
/// @param object 广告对象
- (void)drawFeedAdViewRenderSuccess:(DCUniDrawFeedAdDataObject *)object;
@end

@interface DCUniDrawFeedAd : NSObject
/// 初始化Draw信息流视频
/// @param adpid 广告位标识
/// @param rootViewController 当前页面
/// @param delegate 处理回调方法的代理对象
- (instancetype)initWithAdpid:(NSString *)adpid rootViewController:(UIViewController *)rootViewController andDelegate:(id<DCDrawFeedAdDelegate>)delegate;


/// 加载广告数据
/// @param count 请求广告数量
- (void)loadAdData:(NSInteger)count;
@end

NS_ASSUME_NONNULL_END
