(ns highlight-peeler.core
  (:require [clojure.data.csv :as csv]
            [clojure.string :as str]
            [clojure.java.io :as io]))

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

(defn generate-footnote
  [{:keys [book-title
           chapter-title
           chapter-url]}]
  (str "[fn::" book-title " - " chapter-title " (" chapter-url ")]"))

(defn book-named? [book-name highlight]
  (= book-name (:book-title highlight)))

(defn date->org-date
  [date]
  (str "[" date "]"))

(defn highlight->org
  [{:keys [book-title
           chapter-title
           highlight
           date-of-highlight
           personal-note] :as hl}]
  (with-out-str
    (println (str "* " chapter-title))
    (println (date->org-date date-of-highlight))
    (println (str highlight (generate-footnote hl)))))

(defn load-and-parse-csv-file
  [filename]
  (-> filename load-csv-file csv-data->maps))

(defn extract-and-print
  [filename book]
  (->> (load-and-parse-csv-file filename)
    (filter (partial book-named? book))
    (map highlight->org)
    (apply println)))

(defn -main
  []
  (let [[filename book] *command-line-args*]
    (extract-and-print filename book)))

                                        ; todo sort in reverse date order
                                        ; see if we can take since X
