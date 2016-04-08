(ns ohen.core
  (:require
    [compojure.core :refer [defroutes GET POST]]
    [ohen.data :as data]
    [ohen.log :refer [log]]
    [ring.middleware.params :refer [wrap-params]]  
    [ring.adapter.jetty :as jetty]  
    [ring.util.response :as response]))

;; View functions
(defn index []
  (str 
   "<h1>Hello</h1>"            
   "<h2>GET  /data</h2>"            
   "<h2>POST /data</h2>"))

;; /data handlers

(defn data-get [req]
  (let [params (:params req)]
    {:status 200 :headers  {"Content-Type" "application/json"} :body (data/get-data)}))

(defn data-post [req]
  (let [params (:params req)]
    (data/set-data params)
    {:status 200 :headers  {"Content-Type" "application/json"} :body (data/get-data)}))

;; Routing
(defroutes main-routes
  (GET "/" [] (index))
  (GET "/test" [] "Test!")
  (GET "/data" [] data-get)
  (POST "/data" [] data-post))

(def handler (wrap-params  main-routes))

; (defonce server  (jetty/run-jetty main-routes {:port 3000 :join? false}))  

