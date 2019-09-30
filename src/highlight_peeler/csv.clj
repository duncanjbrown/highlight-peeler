(ns highlight-peeler.csv
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn load-csv-file
  [filename]
  (with-open [reader (io/reader filename)]
    (doall
        (csv/read-csv reader))))

(defn slugify-key
  [string]
  (-> string
      str/lower-case
      (str/replace #"\s+" "-")))

(defn csv-data->maps [csv-data]
  (map zipmap
       (->> (first csv-data)
            (map slugify-key)
            (map keyword)
            repeat)
       (rest csv-data)))

(defn load-csv-highlights
  [filename]
  (-> filename load-csv-file csv-data->maps))
