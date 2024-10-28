// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs

// Theme tables
Table TEMPLATE {
  tid integer [primary key]
  themeid integer
  templatename varchar
}

Table THEME {
  thid integer [primary key]
  primcol integer
  seccol integer
  fontfamily varchar
  fontsize integer
  elementdesign varchar
}

Table COLOR {
  colid integer [primary key]
  colname varchar
  rgbval varchar
  hexval varchar
}

// Core tables
Table BLOK {
  bid integer [primary key]
  templateid integer
  userid integer
  bloktitle integer
  blokimage image
}

Table USER {
  udi integer [primary key]
  username varchar
  firstname varchar
  lastname varchar
  email email
  password binary
  created_at timestamp
}

// Relation tables

Table NOTE_NOTIFICATION {
  nonoid integer [primary key]
  noteid integer
  notificationid integer
}

 Table SHARED_ITEM {
  shid integer [primary key]
  bloknoteid integer
  sectionid integer
  userid integer
  shareduserid integer
  sharedtitle varchar
  created_at timestamp
}

Table BLOK_NOTE {
  bnim integer [primary key]
  blokid integer
  noteid integer
}

// Blok tables
Table NOTIFICATION {
  notid integer [primary key]
  content varchar
}

Table SECTION {
  sid integer [primary key]
  blokid integer
  sectiontitle varchar
  content varchar
}

Table NOTE {
  nid integer [primary key]
  sectiond integer
  notetitle varchar
  content varchar
}


Ref: "NOTIFICATION"."notid" < "NOTE_NOTIFICATION"."notificationid"

Ref: "NOTE"."nid" < "NOTE_NOTIFICATION"."noteid"

Ref: "SECTION"."sid" < "NOTE"."sectiond"

Ref: "BLOK"."bid" < "SECTION"."blokid"

Ref: "TEMPLATE"."tid" < "BLOK"."templateid"

Ref: "THEME"."thid" < "TEMPLATE"."themeid"

Ref: "COLOR"."colid" < "THEME"."primcol"

Ref: "COLOR"."colid" < "THEME"."seccol"

Ref: "USER"."udi" < "BLOK"."userid"

Ref: "USER"."udi" < "SHARED_ITEM"."userid"

Ref: "USER"."udi" < "SHARED_ITEM"."shareduserid"

Ref: "BLOK"."bid" < "BLOK_NOTE"."blokid"

Ref: "NOTE"."nid" < "BLOK_NOTE"."noteid"

Ref: "BLOK_NOTE"."bnim" < "SHARED_ITEM"."bloknoteid"

Ref: "SECTION"."sid" < "SHARED_ITEM"."sectionid"
