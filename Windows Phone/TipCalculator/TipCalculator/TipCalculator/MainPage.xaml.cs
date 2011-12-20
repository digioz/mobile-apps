using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;

namespace TipCalculator
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Constructor
        public MainPage()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Method to determine if the value 
        /// entered is numeric or not
        /// </summary>
        /// <param name="psValue"></param>
        /// <returns></returns>
        public bool IsNumeric(string psValue)
        {
            try
            {
                Double.Parse(psValue);
            }
            catch
            {
                return false;
            }

            return true;
        }

        /// <summary>
        /// Method to Reset all fields
        /// </summary>
        public void resetfields()
        {
            txtAmount.Text = "0.00";
            txtPercentage.Text = "15";
            txtTip.Text = "0.00";
            txtAmount.Focus();
        }

        // Simple button Click event handler to take us to the second page
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/GamePage.xaml", UriKind.Relative));
        }

        private void btnCalculate_Click(object sender, RoutedEventArgs e)
        {
            double ldBill, ldPercent, ldTip = 0.00;

            if (IsNumeric(txtAmount.Text) == true)
            {
                ldBill = Double.Parse(txtAmount.Text);
                ldPercent = Double.Parse(txtPercentage.Text) / 100;
                ldTip = ldBill * ldPercent;

                txtTip.Text = ldTip.ToString("N2");
            }
            else
            {
                resetfields();
            }
        }
    }
}