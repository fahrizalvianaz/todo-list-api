## Todo List API

This API enables users to manage checklists and items within those checklists like Google Keeps. The endpoints are secured using JWT (JSON Web Token) for authentication. Below is a detailed overview of the available endpoints:

### Authentication API

#### Endpoints:

1. **Register User**
   - **Endpoint:** `POST /register` or `POST /register/`
   - **Description:** Registers a new user with the provided details.
   - **Request Body:** `RegisterRequestDto` containing the user’s registration details.
   - **Response:** Returns a success message along with the registration details.

2. **Login User**
   - **Endpoint:** `POST /login` or `POST /login/`
   - **Description:** Authenticates a user and provides a JWT token if the credentials are correct.
   - **Request Body:** `LoginRequestDto` containing the user’s login credentials.
   - **Response:** Returns the JWT token along with a success message.

### Checklist API

#### Endpoints:

1. **Get All Checklists**
   - **Endpoint:** `GET /checklist` or `GET /checklist/`
   - **Description:** Retrieves all checklists associated with the authenticated user.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns a list of checklists along with a success message.

2. **Create a Checklist**
   - **Endpoint:** `POST /checklist` or `POST /checklist/`
   - **Description:** Creates a new checklist for the authenticated user.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Request Body:** `CreateChecklistReqDto` containing the checklist details.
   - **Response:** Returns a success message indicating that the checklist was created.

3. **Delete a Checklist**
   - **Endpoint:** `DELETE /checklist/{idChecklist}`
   - **Description:** Deletes a specified checklist associated with the authenticated user.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns a success message indicating that the checklist was deleted.

### Item Checklist API

#### Endpoints:

1. **Get All Items in a Checklist**
   - **Endpoint:** `GET /checklist/{checklistId}/item`
   - **Description:** Retrieves all items within a specified checklist.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns a list of items along with a success message.

2. **Create an Item in a Checklist**
   - **Endpoint:** `POST /checklist/{checklistId}/item`
   - **Description:** Adds a new item to a specified checklist.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Request Body:** `CreateItemChecklistReqDto` containing details of the item to be added.
   - **Response:** Returns the created item along with a success message.

3. **Get a Specific Item by ID**
   - **Endpoint:** `GET /checklist/{checklistId}/item/{checklistItemId}`
   - **Description:** Retrieves a specific item from a checklist by its ID.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns the item details along with a success message.

4. **Update a Specific Item's Status**
   - **Endpoint:** `PUT /checklist/{checklistId}/item/{checklistItemId}`
   - **Description:** Updates the status of a specific item in a checklist.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns the updated item along with a success message.

5. **Delete a Specific Item**
   - **Endpoint:** `DELETE /checklist/{checklistId}/item/{checklistItemId}`
   - **Description:** Deletes a specific item from a checklist.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Response:** Returns a success message confirming the deletion.

6. **Rename a Specific Item**
   - **Endpoint:** `PUT /checklist/{checklistId}/item/rename/{checklistItemId}`
   - **Description:** Renames a specific item in a checklist.
   - **Authorization:** Requires a valid JWT token in the `Authorization` header.
   - **Request Body:** `CreateItemChecklistReqDto` containing the new name of the item.
   - **Response:** Returns the renamed item along with a success message.

---
