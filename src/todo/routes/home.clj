(ns todo.routes.home
  (:require [todo.layout :as layout]
            [todo.routes.todos :refer [todos-routes]]
            [compojure.core :refer [defroutes
                                    GET
                                    context
                                    routes]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (context "/todos" []
           (routes (todos-routes))))
