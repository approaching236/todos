--name: create-todo!
-- creates a new todo record
INSERT INTO todos
(project, description, issue, blocker, callbacks)
VALUES (:project, :description, :issue, :blocker, :callbacks)

--name: update-todo!
-- update an existing todo record
UPDATE todos
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- name: get-todo
-- retrieve a used given the id.
SELECT * FROM todos
WHERE id = :id
