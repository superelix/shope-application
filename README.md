# A shoping backend design.

### Design structure:
#### Three schemas satisfies the entire business requirement.
##  order
    [customer_id (foreign key)]
    [product_id (foreign key)]
    [date]
    [status]
  
##  product
    [id (primary key)]
    [cost]
    [name]
    [description]
  
##  customer
    [id  (primary key)]
    [name]
    [address]
  
## Relationship Diagram
###    customer--one to many --- order
####    (justification : a customer can place many orders)
###    product --one to many ---order
####    (justification : a particular product can be ordered by many customers.)
