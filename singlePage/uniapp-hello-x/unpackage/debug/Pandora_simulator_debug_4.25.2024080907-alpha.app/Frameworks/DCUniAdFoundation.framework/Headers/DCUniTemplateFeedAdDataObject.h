//
//  DCUniTemplateFeedAdDataObject.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/3/16.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
NS_ASSUME_NONNULL_BEGIN

@interface DCUniTemplateFeedAdDataObject : NSObject
/// 广告视图
@property (nonatomic, readonly) UIView *feedView;

/// 开发者需传入用来弹出目标页的ViewController，一般为当前ViewController
@property (nonatomic, weak) UIViewController *viewController;

/// 渲染
- (void)render;

@end

NS_ASSUME_NONNULL_END
