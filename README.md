### Todo List API

This API enables users to manage checklists and items within those checklists. The endpoints are secured using JWT (JSON Web Token) for authentication. Below is a detailed overview of the available endpoints:

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

#### Authentication:
All endpoints require a valid JWT token. The token must be included in the `Authorization` header as follows: `Authorization: Bearer <token>`.

---
