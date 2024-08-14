//
//  DCUniTemplateFeedAd.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/1/25.
//

#import <Foundation/Foundation.h>
#import "DCUniTemplateFeedAdDataObject.h"
@class DCUniTemplateFeedAd;
NS_ASSUME_NONNULL_BEGIN

@protocol DCTemplateFeedAdDelegate <NSObject>
/// 广告加载完成
/// @param templateAd 加载对象 包含加载渠道信息
/// @param objects 广告内容数组
- (void)templateFeedAdSuccessToLoad:(DCUniTemplateFeedAd *)templateAd data:(NSArray *)objects;


/// 广告加载错误
/// @param error 错误信息
- (void)templateFeedAdFailToLoad:(NSError *)error;

/// 广告关闭
/// @param object 广告对象
- (void)templateFeedAdDidClose:(DCUniTemplateFeedAdDataObject *)object;

/// 广告被点击
/// @param object 广告对象
- (void)templateFeedAdDidClick:(DCUniTemplateFeedAdDataObject *)object;

/// 广告不感兴趣
/// @param object 广告对象
- (void)templateFeedAdDislike:(DCUniTemplateFeedAdDataObject *)object reason:(NSDictionary *)reason;

/// 广告渲染完成
/// @param object 广告对象
- (void)templateFeedAdViewRenderSuccess:(DCUniTemplateFeedAdDataObject *)object;

/// 广告将要展示
/// @param object 广告对象
- (void)templateFeedAdViewWillShow:(DCUniTemplateFeedAdDataObject *)object;
@end

@interface DCUniTemplateFeedAd : NSObject
/// 初始化模板信息流
/// @param adpid 广告位标识
/// @param rootViewController 当前页面视图
/// @param delegate 处理回调方法的代理对象
/// @param size 广告展示的宽高
- (instancetype)initWithAdpid:(NSString *)adpid
           rootViewController:(UIViewController *)rootViewController
                  andDelegate:(id<DCTemplateFeedAdDelegate>)delegate adSize:(CGSize)size;



/// 拉取广告
/// @param count 请求广告数量 范围：1-3
- (void)loadAdData:(NSInteger)count;
@end

NS_ASSUME_NONNULL_END
