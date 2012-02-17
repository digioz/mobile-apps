//
//  ViewController.h
//  SimpleTable
//
//  Created by Pedram Soheil on 2/15/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
<UITableViewDataSource, UITableViewDelegate> 
{
    NSArray *exercises;
}

@end
