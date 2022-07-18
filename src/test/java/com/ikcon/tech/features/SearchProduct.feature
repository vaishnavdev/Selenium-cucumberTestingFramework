Feature: Search and Place the order for a product

@SearchProduct
Scenario Outline: Search a product in both Home Page and Offers Page
Given User is on GreenKart Landing page
When User searched with a ShortName <shortName> and extracted the actual name of the product
Then User searched with same Shortname <shortName> in offers page
And validate product name in offers page matches with Landing page product name

Examples: 
| shortName |
| Tom | 
| Beet |
