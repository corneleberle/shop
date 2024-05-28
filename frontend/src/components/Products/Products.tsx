'use client'

import * as React from "react";
import {gql} from '@/__generated__';
import Product from "@/components/Product/Product";
import {Grid} from "@mui/material";
import {ApolloClient, InMemoryCache, useQuery} from "@apollo/client";

const client = new ApolloClient({
  uri: 'http://localhost:8080/graphql',
  cache: new InMemoryCache(),
});

const PRODUCTS = gql(`
  query Products {
    products(pageNumber: 0, pageSize: 2) {
      id
      name
    }
  }
`);

export default function Products() {
  const {loading, error, data} = useQuery(PRODUCTS, {client});

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
      <Grid container spacing={2}>
        {data?.products ? data?.products.map((product: any) => {
              return (
                  product ?
                      <Product product={product}/>
                      :
                      <div>Invalid product</div>
              );
            })
            :
            <p>No products found</p>
        }
      </Grid>
  );
}
