# webshop application system

**Functional Requirements:**

1. User Management:
   - Users should be able to register, login, and manage their accounts.
   - User roles such as admin and customer(regular user) should be supported.

2. Product Management:
   - Admins should be able to add, update, delete, and view products.
   - Users should be able to browse products, view details, and add them to their shopping cart.

3. Category and Subcategory Management:
   - Admins should be able to create, read, update, and delete subcategories.
   - Admins should be able to assign a group of subcategories to a category.
   - Products should be categorized and displayed under relevant categories/subcategories.

4. Shopping Cart:
   - Users should have a shopping cart where they can add/remove items and update quantities.
   - Cart should persist across sessions for logged-in users.

5. Order Management:
   - Users should be able to view the details, place, or cancel their orders.
   - Admins should be able to view and manage orders, update order status, and process shipments.

6. Address Management:
   - Users should be able to add/edit/delete shipping addresses for orders.

7. Reviews and Ratings:
   - Users should be able to leave reviews and ratings for products.
   - Admins should have the ability to view reviews by product.

8. Authentication and Authorization:
   - Secure authentication and authorization mechanisms should be implemented.
   - Only users with ADMIN role can have access to admin functionalities(e.g. create update, delete operations on products/sub-products ...etc).

9. Search and Filter:
   - Users should be able to search for products and filter results based on various criteria like category, price range, etc.







**Key Features:**

1. Authentication and Authorization:
   - The application provide a secure authentication and authorization mechanisms for users.

2. Role-Based Access Control:
   - Role-based access control is implemented in the application to differentiate between admin and user functionalities.

3. Product Catalog:
   - Display a product catalog with detailed name, descriptions, prices, and availableQuantiy, originCountry, the owner name ...ect.

4. Shopping Cart Management:
   - The application allow users to easily manage their shopping carts, including adding, updating, and removing items.

5. Order Tracking:
   - Provide order tracking functionality for users to monitor the status of their orders.

6. Secure Payment Integration:
   - Integrate secure payment gateways to facilitate safe and convenient transactions.

7. Review and Rating System:
   - Allow users to leave reviews and ratings for products, and display average ratings on product pages.

8. Address Management:
    - Enable users to manage multiple shipping addresses and select them during checkout.

9. Order History:
    - Maintain a history of user orders for reference and reordering.

10. Email Notifications:
    - Send email notifications for order confirmations, shipment updates, etc.