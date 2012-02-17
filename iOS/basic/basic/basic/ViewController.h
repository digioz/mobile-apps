//
//  ViewController.h
//  basic
//
//  Created by Pedram Soheil on 2/3/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController {
    IBOutlet UITextField *txtName;
    IBOutlet UILabel *lblMessage;
}

@property (nonatomic, retain) IBOutlet UITextField *txtName;
@property (nonatomic, retain) IBOutlet UILabel *lblMessage;

- (IBAction) doSomething;
- (IBAction) makeKeyboardGoAway;

@end
