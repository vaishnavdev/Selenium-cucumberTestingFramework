Feature: Place the order for a product

@PlaceOrder
Scenario Outline: Search a product in both Home Page and Offers Page
Given User is on GreenKart Landing page
When User searched with a ShortName <shortName> and extracted the actual name of the product
And Added "3" items of selected product to cart
Then User proceeds to checkout page and validate the <shortName> items in checkout page
And Check the user has ability to enter promocode and place the order

Examples: 
| shortName |
| Tom | 
