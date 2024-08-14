//
//  DCUniDrawFeedAdDataObject.h
//  DCUniAdFoundation
//
//  Created by dcloud on 2022/3/17.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
NS_ASSUME_NONNULL_BEGIN

@interface DCUniDrawFeedAdDataObject : NSObject
/// 注册view
/// @param view  展示当前视图的view
- (void)registerContainer:(UIView *)view;

///  注销数据对象
- (void)unregister;

/// 开发者需传入用来弹出目标页的ViewController，一般为当前ViewController
@property (nonatomic, weak) UIViewController *viewController;
@end

NS_ASSUME_NONNULL_END
