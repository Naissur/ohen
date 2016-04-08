(ns ohen.log)

(defn append-to-file
  [file-name s]
  (spit file-name s :append true))

(defn now [] (new java.util.Date))

(defn log [msg]
  (let
    [log-msg (str "[ " (.toString ( now )) " ]:  " msg)]
    (append-to-file "log.txt" (str log-msg "\n"))))

