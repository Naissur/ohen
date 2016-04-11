(ns ohen.data
  (:require  [clojure.data.json :as json])
  (:gen-class))

(defonce data (atom "Sample data!"))

(defn get-data []
  (deref data))

(defn set-data [newData]
  (reset! data newData))
