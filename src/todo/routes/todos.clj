(ns todo.routes.todos
  (:require [todo.layout :as layout]
            [compojure.core :refer [routes GET]]))

(defn index []
  (layout/render "todos/index.html"))

(defn show [id]
  (layout/render "todos/show.html"))

(defn todos-routes []
  (routes
    (GET "/" [] (index))
    (GET "/:id" [id] (show id))))
