(ns ohen.data
  (:require  [clojure.data.json :as json])
  (:gen-class))

(defonce data (atom nil))

(defn get-data []
  (deref data))

(defn set-data [newData]
  (reset! data newData))
