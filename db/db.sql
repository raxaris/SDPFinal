--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-11-09 19:45:19

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16415)
-- Name: cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cars (
    id integer NOT NULL,
    brand character varying(20) NOT NULL,
    model character varying(20) NOT NULL,
    engine_type character varying(10) NOT NULL,
    fuel character varying(20),
    torque integer NOT NULL,
    volume double precision,
    power integer NOT NULL,
    transmission character varying(20) NOT NULL,
    gears integer NOT NULL,
    years integer NOT NULL,
    price integer NOT NULL,
    class "char",
    vin integer NOT NULL,
    color character varying(20) NOT NULL
);


ALTER TABLE public.cars OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17476)
-- Name: cars_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cars ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cars_id_seq
    START WITH 154
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 17478)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    isadmin boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17477)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 216
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3178 (class 2604 OID 17481)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3325 (class 0 OID 16415)
-- Dependencies: 214
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cars (id, brand, model, engine_type, fuel, torque, volume, power, transmission, gears, years, price, class, vin, color) FROM stdin;
38	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2023	51000	S	9353314	Red
37	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2022	49000	S	8781702	Red
36	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2021	47000	S	2935565	Yellow
35	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2020	45000	S	5560648	Blue
24	Volkswagen	Polo	ICE	Petrol	240	1.6	141	Auto	4	2020	20000	C	6889022	White
25	Volkswagen	id.3	Electro	\N	432	\N	176	Auto	1	2019	39000	C	3352606	Black
46	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2022	260000	S	6188702	Blue
1	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2021	44000	S	8580804	White
2	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2022	63000	S	7326406	Black
3	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2018	250000	S	5139814	Grey
4	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2017	500000	S	9958959	Pink
5	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2018	230000	S	6800133	White
6	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2016	63000	S	8493503	Brown
7	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2021	300000	S	5339475	Green
8	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2020	89000	S	9546316	Purple
9	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2021	110000	E	2009699	Yellow
10	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2019	85000	E	3964742	Yellow
11	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2020	104000	E	4473463	Grey
12	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2022	73000	E	1032752	Grey
14	Mercedes-Benz	E-class	ICE	Petrol	370	3	362	Auto	9	2022	67000	E	9664865	Red
15	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2017	45000	E	6750700	Black
16	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2021	65000	E	4231576	Red
17	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2017	110000	E	9075861	White
18	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2019	16000	C	3808478	Black
19	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2021	22000	C	2325918	Blue
20	Hyundai	i30	ICE	Petrol	142	1.6	112	Auto	4	2020	23000	C	8574900	Green
21	Toyota	Corolla	ICE	Petrol	190	2	143	Auto	4	2020	21000	C	6710420	White
22	Toyota	Auris	ICE	Petrol	185	1.6	121	Auto	4	2012	18000	C	9628934	Grey
23	Toyota	Prius	Electro	\N	283	\N	101	Manual	5	2022	30000	C	8176821	Black
26	Volkswagen	Golf 7	ICE	Petrol	350	2	163	Auto	7	2016	26000	C	2958738	White
13	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2022	72000	E	9817064	Red
0	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	110000	S	3626510	Black
32	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	120000	S	7380301	White
31	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	112000	S	2942160	Green
30	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	110500	S	3145266	Yellow
29	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	101000	S	3216900	Blue
28	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	115000	S	1512012	Black
27	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	111000	S	3364837	Grey
34	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2021	43000	S	4836130	Green
33	BMW	Z4	ICE	Petrol	500	3	340	Auto	8	2022	44500	S	3039916	White
44	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2022	63000	S	2533397	Orange
43	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2021	64000	S	3444737	Brown
42	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2023	65000	S	8276199	Red
41	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2022	70000	S	4119718	Cyan
40	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2022	63000	S	8963712	Cyan
39	BMW	M2	ICE	Petrol	406	3	460	Auto	8	2021	60000	S	3624707	White
45	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2018	250000	S	6712948	Purple
47	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2019	252000	S	5254939	Red
48	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2023	300000	S	6523986	Green
50	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2020	2700000	S	5928762	Yellow
51	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2019	260000	S	3303652	Yellow
49	Lamborghini	Huracan LP 580-2	ICE	Petrol	540	5.2	580	Auto	7	2022	310000	S	2083789	Green
155	Porsche	911 Bexultan Edition	ICE	Petrol	800	3.7	650	Auto	5	2021	333333	S	7778888	Yellow
52	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2019	485000	S	6401041	Blue
53	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2018	480000	S	9281102	Green
54	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2022	500000	S	4509519	Yellow
55	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2022	500000	S	3988024	Orange
56	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2017	470000	S	3040395	Red
57	Lamborghini	Aventador LP 780-4	ICE	Petrol	690	6.4	780	Auto	7	2018	495000	S	6190442	Red
58	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2021	240000	S	1388688	Red
59	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2019	220000	S	5598676	Black
60	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2020	230000	S	4681652	Black
61	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2022	250000	S	1951230	Black
62	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2020	235000	S	7526629	Yellow
158	BMW	iX	Electro	\N	630	\N	326	Auto	1	2023	110000	\N	3626510	Black
63	Lamborghini	Urus	ICE	Petrol	850	4	650	Auto	5	2019	224000	S	2203746	Yellow
159	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2017	45000	\N	6750700	Black
64	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2020	70000	S	3270201	Red
65	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2022	72000	S	2391757	Black
66	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2017	65000	S	2237306	White
67	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2019	67000	S	6605755	Green
68	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2018	64000	S	6754795	Blue
69	Porsche	Cayman	ICE	Petrol	380	2	300	Auto	6	2017	63000	S	7110687	Yellow
70	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2021	300000	S	4654843	Red
71	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2022	310000	S	3772894	Yellow
72	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2021	315000	S	4487258	Green
73	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2023	330000	S	3166751	White
74	Porsche	911 Turbo-S	ICE	Petrol	800	3.7	650	Auto	5	2022	305000	S	4973988	White
75	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2021	90000	S	7189348	Blue
76	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2020	87000	S	7204274	Yellow
77	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2023	100000	S	8823928	Red
78	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2020	92000	S	6266118	Green
79	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2022	95000	S	6088457	Blue
80	Porsche	Taycan	Electro	Petrol	1050	\N	470	Auto	2	2021	93000	S	9658484	Cyan
81	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2021	117500	E	1343575	Red
82	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2020	115000	E	5841463	Yellow
83	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2023	123000	E	3608424	Black
84	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2022	125000	E	4961620	Black
85	Audi	RS6	ICE	Petrol	700	4	600	Auto	8	2023	120000	E	9958141	Black
86	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2023	90000	E	7372357	Red
87	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2019	80000	E	6644627	White
88	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2022	87000	E	1007476	White
89	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2021	89000	E	7371180	Black
90	Audi	S7	ICE	Petrol	480	2.9	440	Auto	7	2020	82000	E	8533277	Black
91	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2023	110000	E	4067373	Nardo Grey
92	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2020	105000	E	3119698	Nardo Grey
93	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2021	109000	E	2342516	Nardo Grey
94	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2022	115000	E	3197451	Nardo Grey
95	Audi	e-tron GT	Electro	\N	664	\N	300	Auto	5	2021	111000	E	6051645	Nardo Grey
96	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2023	81000	E	6683270	Green
97	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2022	72000	E	6879675	Blue
98	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2023	80000	E	3467359	White
99	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2022	77000	E	7720448	Black
100	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2023	76000	E	6551452	Black
101	Mercedes-Benz	CLS	ICE	Petrol	370	3	362	Auto	9	2022	74000	E	7708617	Grey
102	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2022	75000	E	3933515	Black
103	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2023	76000	E	2783024	Black
104	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2023	77000	E	1887031	Blue
105	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2022	69000	E	1441470	Red
106	Mercedes-Benz	CLA	ICE	Diesel	340	3	348	Auto	9	2022	73000	E	1205902	Red
107	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2022	48000	E	2582203	Grey
108	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2018	45000	E	5078178	White
109	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2019	47000	E	8607002	Black
110	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2020	45000	E	8671045	Red
111	BMW	520d	ICE	Diesel	380	2	181	Manual	6	2017	44000	E	1869574	Blue
112	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2023	70000	E	7273603	Brown
113	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2021	67000	E	8263365	Green
114	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2021	68000	E	1583050	Black
115	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2023	69000	E	3565947	White
116	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2021	66500	E	8165498	Blue
117	BMW	540i	ICE	Petrol	332	3	335	Manual	8	2022	68000	E	4206995	Blue
118	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2017	120000	E	1203443	Black
119	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2018	110000	E	3863523	Orange
120	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2022	119500	E	1701231	Grey
121	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2023	120000	E	9868213	White
122	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2019	114000	E	2017427	Green
123	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2020	115000	E	6096441	Black
124	BMW	M5 F90	ICE	Petrol	553	4.4	600	Auto	8	2017	112000	E	4301132	Blue
125	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2019	15900	C	7764666	Orange
126	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2023	18000	C	6023682	Yellow
127	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2022	17500	C	5367084	Red
128	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2019	16700	C	2635888	Black
129	Hyundai	Accent	ICE	Petrol	164	1.6	116	Manual	6	2020	16500	C	4879007	Black
130	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2022	24100	C	1627349	Brown
131	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2023	24000	C	9184614	White
132	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2022	23000	C	8447581	Black
133	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2021	22500	C	9114718	Grey
134	Hyundai	Elantra	ICE	Petrol	178	2	128	Auto	4	2021	22200	C	4506457	Grey
140	Toyota	Corolla	ICE	Petrol	190	2	143	Auto	4	2021	24700	C	3762822	Orange
139	Toyota	Auris	ICE	Petrol	185	1.6	121	Auto	4	2014	17900	C	1653767	Black
138	Toyota	Prius	Electro	\N	283	\N	101	Manual	5	2023	34000	C	8762940	White
137	Volkswagen	Polo	ICE	Petrol	240	1.6	141	Auto	4	2021	21000	C	3584704	Blue
136	Volkswagen	id.3	Electro	\N	432	\N	176	Auto	1	2020	39800	C	2942651	Red
146	Toyota	Corolla	ICE	Petrol	190	2	143	Auto	4	2021	22850	C	7061683	Orange
145	Toyota	Auris	ICE	Petrol	185	1.6	121	Auto	4	2017	19500	C	1891140	Blue
144	Toyota	Prius	Electro	\N	283	\N	101	Manual	5	2023	33900	C	4374291	Green
153	Toyota	Corolla	ICE	Petrol	190	2	143	Auto	4	2021	22000	C	4107882	Black
152	Toyota	Auris	ICE	Petrol	185	1.6	121	Auto	4	2016	18500	C	8888042	Grey
151	Toyota	Prius	Electro	\N	283	\N	101	Manual	5	2022	35000	C	2679752	Green
149	Volkswagen	id.3	Electro	\N	432	\N	176	Auto	1	2020	41200	C	5371964	Black
147	Volkswagen	Golf 7	ICE	Petrol	350	2	163	Auto	7	2018	28200	C	8274446	White
150	Volkswagen	Polo	ICE	Petrol	240	1.6	141	Auto	4	2021	22500	C	4649492	Yellow
135	Volkswagen	Golf 7	ICE	Petrol	350	2	163	Auto	7	2018	32500	C	8989950	Purple
\.


--
-- TOC entry 3328 (class 0 OID 17478)
-- Dependencies: 217
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, email, isadmin) FROM stdin;
1	alice	password1	alice@example.com	f
2	bob	password2	bob@example.com	f
3	charlie	password3	charlie@example.com	f
4	david	password4	david@example.com	f
5	eve	password5	eve@example.com	f
6	frank	password6	frank@example.com	f
7	grace	password7	grace@example.com	f
8	harry	password8	harry@example.com	f
9	irene	password9	irene@example.com	f
0	admin	admin	admin@admin.com	t
11	bexultan	kpoplover2004	bekarakhan@gmail.com	f
10	nariman	poelgovna2004	narik@narko.com	f
12	merey	wholebakery2005	bakery@gmail.gov	f
13	alibaba	aliloshok2004	aliloh@gmail.com	f
\.


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 215
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_id_seq', 159, true);


--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 216
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 13, true);


--
-- TOC entry 3180 (class 2606 OID 16423)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 3182 (class 2606 OID 17485)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2023-11-09 19:45:20

--
-- PostgreSQL database dump complete
--

