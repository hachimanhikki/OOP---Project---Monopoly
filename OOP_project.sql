PGDMP     .                    x            OOP    11.5    11.5     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    24585    OOP    DATABASE     �   CREATE DATABASE "OOP" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Kazakhstan.1251' LC_CTYPE = 'Russian_Kazakhstan.1251';
    DROP DATABASE "OOP";
             postgres    false            �            1259    24586    board    TABLE     �   CREATE TABLE public.board (
    cell_id integer NOT NULL,
    name character varying(42),
    type character varying(42),
    cost numeric,
    color character varying(42)
);
    DROP TABLE public.board;
       public         postgres    false            �
          0    24586    board 
   TABLE DATA               A   COPY public.board (cell_id, name, type, cost, color) FROM stdin;
    public       postgres    false    196   I       }
           2606    24593    board st_pk 
   CONSTRAINT     N   ALTER TABLE ONLY public.board
    ADD CONSTRAINT st_pk PRIMARY KEY (cell_id);
 5   ALTER TABLE ONLY public.board DROP CONSTRAINT st_pk;
       public         postgres    false    196            �
   �   x�}�M� �u8EO��-U��&�L툐������\��yŴBfrz�ZkTք^m��1�N�)�؊&�T�2��snоq��8�T�?)t�P�L[6N˄ͼ^�͉(�p�b�Aea�P#���_�ѐ_��Y���$���&����(w�;}��ؤ��� ˳݉�|�����\�\q��Q��wj�:|��QJ=\�     