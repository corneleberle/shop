import * as React from 'react';
import Container from '@mui/material/Container';
import Box from '@mui/material/Box';
import ResponsiveAppBar from "@/components/AppBar/AppBar";
import Products from "@/components/Products/Products";

export default function Home() {
  return (
      <main>
        <ResponsiveAppBar/>
        <Container maxWidth="lg">
          <Box
              sx={{
                my: 4,
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
              }}
          >
            <Products/>
          </Box>
        </Container>
      </main>
  );
}
