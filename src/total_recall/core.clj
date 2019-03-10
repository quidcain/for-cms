(ns total-recall.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response
                                        status]]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!1111"))


(defn my-println
  []
  (println "hey"))

(defn handler
  [_]
  (response [
             {:name "daniel" :surname "radezky"}
             {:name "daniel" :surname "radezky"}
             {:name "daniel" :surname "radezky"}
             {:name "daniel" :surname "radezky"}
             {:name "daniel" :surname "radezky"}
             {:name "daniel" :surname "radezky"}
             ]))

(def app
  (-> handler
      wrap-json-response))

(def reloadable-app
  (wrap-reload app))

(defn create-start-server []
  (run-jetty #'reloadable-app {:port 3000 :join? false}))

;; Usefull commands to run server from REPL
;; 
;;(def server (create-start-server))
;;(.start server)
;;(.stop server)
