//
//  ViewController.m
//  DataSources
//
//  Created by Pedram Soheil on 2/10/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import "ViewController.h"

@implementation ViewController

@synthesize moodPicker;

- (NSInteger) numberOfComponentsInPickerView:(UIPickerView *)pickerView 
{
    return 1;
}

- (NSInteger) pickerView:(UIPickerView *)pickerView 
              numberOfRowsInComponent:(NSInteger)component
{
    return moods.count;
}

- (NSString *) pickerView:(UIPickerView *)pickerView 
               titleForRow:(NSInteger)row 
               forComponent:(NSInteger)component 
{
    return [moods objectAtIndex:row];
}

- (void) pickerView:(UIPickerView *)pickerView 
         didSelectRow:(NSInteger)row 
         inComponent:(NSInteger)component
{
    UIColor *newColor;
    switch (row) {
        case 0: case 1: case 2:
            newColor = [UIColor yellowColor];
            break;
        case 3: case 4: case 5:
            newColor = [UIColor grayColor];
            break;
        case 6: case 7: case 8:
            newColor = [UIColor blackColor];
            break;
        default:
            newColor = [UIColor redColor];
            break;
    }
    self.view.backgroundColor = newColor;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    moods = [[NSArray alloc] initWithObjects:
             @"Ecstatic", @"Happy", @"Cheerful",
             @"Fine", @"Tired", @"Maudlin",
             @"Depressed", @"Overwhelmed", nil];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
