//
//  ViewController.m
//  SimpleTable
//
//  Created by Pedram Soheil on 2/15/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import "ViewController.h"

@implementation ViewController

- (NSInteger)tableView:(UITableView *)tableView 
             numberOfRowsInSection:(NSInteger)section
{
    return exercises.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView 
                     cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    // create a cell
    UITableViewCell *cell = [[UITableViewCell alloc]
                             initWithStyle:UITableViewCellStyleDefault reuseIdentifier:@"cell"];
    
    // fill it with content
    cell.textLabel.text = [exercises objectAtIndex:indexPath.row];
    
    // return cell
    return cell;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    // load from plist
    NSString *myfile = [[NSBundle mainBundle] pathForResource:@"data1" ofType:@"plist"];
    
    exercises = [[NSArray alloc] initWithContentsOfFile:myfile];
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
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
