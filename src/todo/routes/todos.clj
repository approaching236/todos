(ns todo.routes.todos
  (:require [todo.layout :as layout]
            [compojure.core :refer [routes GET]]
            [ring.util.response :refer [redirect]]
            [guestbook.db.core :as db]))

(defn index []
  (layout/render "todos/index.html"))

(defn show [id]
  (layout/render "todos/show.html"
                 {:id id}))

(defn new-todo [id]
  (do
    (db/create-todo! "todo"
                  "be a badass"
                  "I'm almost too badass to be more badass"
                  "nothing is stopping me"
                  "tell everyone")
    (redirect "/todos")))

(defn todos-routes []
  (routes
    (GET "/" [] (index))
    (GET "/new" [] (redirect "/todos"))
    (GET "/:id" [id] (show id))))
