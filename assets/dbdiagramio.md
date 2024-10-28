// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs


// Core tables
Table BLOK {
  bid integer [primary key]
  templateid integer
  userid integer
  bloktitle varchar
  blokimage image
}

Table USER {
  uid integer [primary key]
  username varchar
  firstname varchar
  lastname varchar
  email email
  password binary
  created_at timestamp
}

// Blok tables
Table SECTION {
  sid integer [primary key]
  blokid integer
  sectiontitle varchar
}

Table NOTE {
  nid integer [primary key]
  sectionid integer
  notetitle varchar
}

Table NOTIFICATION {
  notid integer [primary key]
  content varchar
}

// Relation tables
Table BLOK_NOTE {
  bnid integer [primary key]
  blokid integer
  noteid integer
}

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
  sharedwithid integer
  description varchar
  created_at timestamp
}

// Layout and themes
Table TEMPLATE {
  tid integer [primary key]
  themeid integer
  templatename varchar
}

Table THEME {
  thid integer [primary key]
  primcol integer
  seccol integer
  font_family varchar
  font_size integer
  element_design varchar
}

Table COLOR {
  colid integer [primary key]
  colname varchar
  rgbval varchar
  hexval varchar
}


Ref: "COLOR"."colid" < "THEME"."primcol"

Ref: "COLOR"."colid" < "THEME"."seccol"

Ref: "THEME"."thid" < "TEMPLATE"."themeid"

Ref: "USER"."uid" < "BLOK"."userid"

Ref: "TEMPLATE"."tid" < "BLOK"."templateid"

Ref: "BLOK"."bid" < "BLOK_NOTE"."blokid"



Ref: "NOTE"."nid" < "NOTE_NOTIFICATION"."noteid"

Ref: "NOTIFICATION"."notid" < "NOTE_NOTIFICATION"."notificationid"

Ref: "BLOK"."bid" < "SECTION"."blokid"

Ref: "SECTION"."sid" < "NOTE"."sectionid"

Ref: "BLOK_NOTE"."bnid" < "SHARED_ITEM"."bloknoteid"

Ref: "SECTION"."sid" < "SHARED_ITEM"."sectionid"

Ref: "USER"."uid" < "SHARED_ITEM"."userid"

Ref: "NOTE"."nid" < "BLOK_NOTE"."noteid"

Ref: "USER"."uid" < "SHARED_ITEM"."sharedwithid"
