--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS ngheluon;
--
-- Name: ngheluon; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE ngheluon WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8';


ALTER DATABASE ngheluon OWNER TO postgres;

\connect ngheluon

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    id uuid NOT NULL,
    username character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    lastlogin_at timestamp(0) without time zone,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    avatar character varying(255)
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- Name: authors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authors (
    id uuid NOT NULL,
    name character varying(255) NOT NULL,
    description text NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.authors OWNER TO postgres;

--
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id uuid NOT NULL,
    title character varying(255) NOT NULL,
    active boolean DEFAULT true NOT NULL,
    slug character varying(255) NOT NULL,
    thumb character varying(255) NOT NULL,
    short_desc text NOT NULL,
    helper text NOT NULL,
    author_id uuid NOT NULL,
    num_of_chapter integer NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    banner character varying(255) NOT NULL,
    cover character varying(255) NOT NULL,
    isbn character varying(255) NOT NULL,
    title_en character varying(255) NOT NULL,
    full_desc character varying(255) NOT NULL,
    time_read integer DEFAULT 0 NOT NULL,
    time_listen integer DEFAULT 0 NOT NULL,
    is_free boolean NOT NULL
);


ALTER TABLE public.books OWNER TO postgres;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id uuid NOT NULL,
    title character varying(255) NOT NULL,
    slug character varying(255) NOT NULL,
    active boolean DEFAULT true NOT NULL,
    description text,
    icon character varying(255) NOT NULL,
    thumb character varying(255) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: category_books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category_books (
    id integer NOT NULL,
    category_id uuid NOT NULL,
    book_id uuid NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.category_books OWNER TO postgres;

--
-- Name: category_books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_books_id_seq OWNER TO postgres;

--
-- Name: category_books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_books_id_seq OWNED BY public.category_books.id;


--
-- Name: chapters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chapters (
    id uuid NOT NULL,
    title character varying(255) NOT NULL,
    "order" integer NOT NULL,
    book_id uuid NOT NULL,
    short_desc text NOT NULL,
    content text NOT NULL,
    file character varying(255) NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.chapters OWNER TO postgres;

--
-- Name: configs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.configs (
    id uuid NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    key character varying(255) NOT NULL,
    value text NOT NULL,
    description text NOT NULL
);


ALTER TABLE public.configs OWNER TO postgres;

--
-- Name: highlight_books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.highlight_books (
    id integer NOT NULL,
    highlight_id uuid NOT NULL,
    book_id uuid NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.highlight_books OWNER TO postgres;

--
-- Name: highlight_books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.highlight_books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.highlight_books_id_seq OWNER TO postgres;

--
-- Name: highlight_books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.highlight_books_id_seq OWNED BY public.highlight_books.id;


--
-- Name: highlights; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.highlights (
    id uuid NOT NULL,
    title character varying(255) NOT NULL,
    active boolean DEFAULT true NOT NULL,
    slug character varying(255) NOT NULL,
    description text NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone,
    thumb character varying(255) NOT NULL,
    banner character varying(255) NOT NULL,
    num_of_book integer NOT NULL
);


ALTER TABLE public.highlights OWNER TO postgres;

--
-- Name: libraries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libraries (
    id uuid NOT NULL,
    user_id integer NOT NULL,
    book_id integer NOT NULL,
    status character varying(255) NOT NULL,
    process integer NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.libraries OWNER TO postgres;

--
-- Name: migrations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.migrations (
    id integer NOT NULL,
    migration character varying(255) NOT NULL,
    batch integer NOT NULL
);


ALTER TABLE public.migrations OWNER TO postgres;

--
-- Name: migrations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.migrations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.migrations_id_seq OWNER TO postgres;

--
-- Name: migrations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.migrations_id_seq OWNED BY public.migrations.id;


--
-- Name: topic_books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topic_books (
    id integer NOT NULL,
    topic_id uuid NOT NULL,
    book_id uuid NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.topic_books OWNER TO postgres;

--
-- Name: topic_books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topic_books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topic_books_id_seq OWNER TO postgres;

--
-- Name: topic_books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topic_books_id_seq OWNED BY public.topic_books.id;


--
-- Name: topics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topics (
    id uuid NOT NULL,
    title character varying(255) NOT NULL,
    active boolean DEFAULT true NOT NULL,
    slug character varying(255) NOT NULL,
    description text NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.topics OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    username character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    token character varying(255) NOT NULL,
    chargebee_id character varying(255) NOT NULL,
    time_expired timestamp(0) without time zone NOT NULL,
    created_at timestamp(0) without time zone,
    updated_at timestamp(0) without time zone
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: category_books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_books ALTER COLUMN id SET DEFAULT nextval('public.category_books_id_seq'::regclass);


--
-- Name: highlight_books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.highlight_books ALTER COLUMN id SET DEFAULT nextval('public.highlight_books_id_seq'::regclass);


--
-- Name: migrations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.migrations ALTER COLUMN id SET DEFAULT nextval('public.migrations_id_seq'::regclass);


--
-- Name: topic_books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topic_books ALTER COLUMN id SET DEFAULT nextval('public.topic_books_id_seq'::regclass);


--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (id, username, email, password, lastlogin_at, created_at, updated_at, avatar) FROM stdin;
ea302ab8-67dc-3bed-afc8-4215a99f1f68	admin	admin@gmail.com	$2y$10$1shUh0/B//wVel2lird4c.xuQPQ9e1EkamzsqX0aFadMHf5.uIqvW	\N	2019-09-30 23:33:19	2019-09-30 23:33:19	\N
\.


--
-- Data for Name: authors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authors (id, name, description, created_at, updated_at) FROM stdin;
1343c6c0-e3a0-11e9-a064-57a05e683128	Nguyễn Nhật Ánh	<p>a</p>	2019-09-30 23:33:46	2019-09-30 23:33:46
\.


--
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.books (id, title, active, slug, thumb, short_desc, helper, author_id, num_of_chapter, created_at, updated_at, banner, cover, isbn, title_en, full_desc, time_read, time_listen, is_free) FROM stdin;
55226e20-e3a0-11e9-a86b-89dc90a92984	Tôi thấy hoa vàng trên cỏ xanh	t	toi-thay-hoa-vang-tren-co-xanh	https://storage.googleapis.com/nl-content/images/book/2019-09-30/toi-thay-hoa-vang-tren-co-xanh/5d922ed8c4eb4_thumb_1442218806261_500.jpg	<p>sa</p>	<p>das</p>	1343c6c0-e3a0-11e9-a064-57a05e683128	1	2019-09-30 23:35:37	2019-09-30 23:36:17	https://storage.googleapis.com/nl-content/images/book/2019-09-30/toi-thay-hoa-vang-tren-co-xanh/5d922ed943897_banner_1442218806261_500.jpg	https://storage.googleapis.com/nl-content/images/book/2019-09-30/toi-thay-hoa-vang-tren-co-xanh/5d922ed91b33b_cover_1442218806261_500.jpg	dsa	Tôi thấy hoa vàng trên cỏ xanh	<p>dsa</p>	2	3	f
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (id, title, slug, active, description, icon, thumb, created_at, updated_at) FROM stdin;
93ed9cc0-e3a0-11e9-88f2-f9e9058911bc	Cate	cate	t	<p>dsa</p>		https://storage.googleapis.com/nl-content/images/category/2019-09-30/cate/5d922f427748d_thumb_sach-hai-so-phan.jpg	2019-09-30 23:37:22	2019-09-30 23:37:22
\.


--
-- Data for Name: category_books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category_books (id, category_id, book_id, created_at, updated_at) FROM stdin;
1	93ed9cc0-e3a0-11e9-88f2-f9e9058911bc	55226e20-e3a0-11e9-a86b-89dc90a92984	\N	\N
\.


--
-- Data for Name: chapters; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chapters (id, title, "order", book_id, short_desc, content, file, created_at, updated_at) FROM stdin;
6cc266b0-e3a0-11e9-b0c2-136724d5a261	Chap 1	1	55226e20-e3a0-11e9-a86b-89dc90a92984	<p>a</p>	<p>a</p>	https://storage.googleapis.com/nl-content/mp4/2019-09-30/toi-thay-hoa-vang-tren-co-xanh/5d922f00b447d_chap_1_mp4_adapt_adapt_01.mp4	2019-09-30 23:36:17	2019-09-30 23:36:17
\.


--
-- Data for Name: configs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.configs (id, created_at, updated_at, key, value, description) FROM stdin;
\.


--
-- Data for Name: highlight_books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.highlight_books (id, highlight_id, book_id, created_at, updated_at) FROM stdin;
1	7ae70300-e3a0-11e9-aed3-378602e0d5e9	55226e20-e3a0-11e9-a86b-89dc90a92984	\N	\N
\.


--
-- Data for Name: highlights; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.highlights (id, title, active, slug, description, created_at, updated_at, thumb, banner, num_of_book) FROM stdin;
7ae70300-e3a0-11e9-aed3-378602e0d5e9	Sách hay	t	sach-hay	<p>da</p>	2019-09-30 23:36:40	2019-09-30 23:36:50	https://storage.googleapis.com/nl-content/images/highlight/2019-09-30/sach-hay/5d922f184c845_thumb_sach-hai-so-phan.jpg	https://storage.googleapis.com/nl-content/images/highlight/2019-09-30/sach-hay/5d922f189781e_banner_sach-hai-so-phan.jpg	1
\.


--
-- Data for Name: libraries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libraries (id, user_id, book_id, status, process, created_at, updated_at) FROM stdin;
\.


--
-- Data for Name: migrations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.migrations (id, migration, batch) FROM stdin;
1	2019_08_14_210006_create_users_table	1
2	2019_08_14_210032_create_admin_table	1
3	2019_08_14_210103_create_book_table	1
4	2019_08_14_210135_create_highlight_table	1
5	2019_08_14_210251_create_highlight_book_table	1
6	2019_08_14_210322_create_topic_book_table	1
7	2019_08_14_210330_create_topic_table	1
8	2019_08_14_210410_create_category_table	1
9	2019_08_14_210637_create_category_book_table	1
10	2019_08_14_210658_create_category_chapter_table	1
11	2019_08_14_210735_create_category_library_table	1
12	2019_08_14_212352_create_author_table	1
13	2019_08_14_214500_create_config_table	1
14	2019_08_18_105758_add_field_to_book_table	1
15	2019_08_24_151111_add_title_en_to_book_table	1
16	2019_08_24_151728_add_thumb_en_to_book_table	1
17	2019_08_24_180932_add_is_free_to_book_table	1
18	2019_09_12_212635_update_book_table	1
19	2019_09_12_213113_update_highlight_table	1
20	2019_09_16_223025_update_chapter_table	1
21	2019_09_18_205854_add_votes_to_users_table	1
22	2019_09_18_211229_add_avatar_admin_table	1
23	2019_09_24_210115_update_table_name	1
24	2019_09_30_204959_add_title_to_chapters_table	1
25	2019_09_30_205242_add_active_to_books_table	1
26	2019_09_30_205321_add_active_to_highlights_table	1
27	2019_09_30_205338_add_active_to_topics_table	1
28	2019_09_30_205409_add_active_to_categories_table	1
29	2019_09_30_211938_update_type_data_table	1
30	2019_09_30_215356_update_primary_data_table	1
31	2019_09_30_221213_update_primary_id_data_table	1
32	2019_09_30_221345_update_table_name_data_table	1
33	2019_09_30_222141_update_table_name_data_table	1
34	2019_09_30_222348_update_table_name_data_table	1
35	2019_09_30_222923_update_table_name_data_table	1
\.


--
-- Data for Name: topic_books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topic_books (id, topic_id, book_id, created_at, updated_at) FROM stdin;
1	862cb790-e3a0-11e9-88f0-e7f89af9b220	55226e20-e3a0-11e9-a86b-89dc90a92984	\N	\N
\.


--
-- Data for Name: topics; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topics (id, title, active, slug, description, created_at, updated_at) FROM stdin;
862cb790-e3a0-11e9-88f0-e7f89af9b220	Topic	t	topic	<p>dsa</p>	2019-09-30 23:36:59	2019-09-30 23:36:59
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, phone, token, chargebee_id, time_expired, created_at, updated_at) FROM stdin;
\.


--
-- Name: category_books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_books_id_seq', 1, true);


--
-- Name: highlight_books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.highlight_books_id_seq', 1, true);


--
-- Name: migrations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.migrations_id_seq', 35, true);


--
-- Name: topic_books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topic_books_id_seq', 1, true);


--
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- Name: authors authors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (id);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: category_books category_books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_books
    ADD CONSTRAINT category_books_pkey PRIMARY KEY (id);


--
-- Name: chapters chapters_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chapters
    ADD CONSTRAINT chapters_pkey PRIMARY KEY (id);


--
-- Name: configs configs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.configs
    ADD CONSTRAINT configs_pkey PRIMARY KEY (id);


--
-- Name: highlight_books highlight_books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.highlight_books
    ADD CONSTRAINT highlight_books_pkey PRIMARY KEY (id);


--
-- Name: highlights highlights_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.highlights
    ADD CONSTRAINT highlights_pkey PRIMARY KEY (id);


--
-- Name: libraries libraries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libraries
    ADD CONSTRAINT libraries_pkey PRIMARY KEY (id);


--
-- Name: migrations migrations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.migrations
    ADD CONSTRAINT migrations_pkey PRIMARY KEY (id);


--
-- Name: topic_books topic_books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topic_books
    ADD CONSTRAINT topic_books_pkey PRIMARY KEY (id);


--
-- Name: topics topics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topics
    ADD CONSTRAINT topics_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

