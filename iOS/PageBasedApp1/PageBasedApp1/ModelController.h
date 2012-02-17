//
//  ModelController.h
//  PageBasedApp1
//
//  Created by Pedram Soheil on 2/16/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <Foundation/Foundation.h>

@class DataViewController;

@interface ModelController : NSObject <UIPageViewControllerDataSource>
- (DataViewController *)viewControllerAtIndex:(NSUInteger)index storyboard:(UIStoryboard *)storyboard;
- (NSUInteger)indexOfViewController:(DataViewController *)viewController;
@end
