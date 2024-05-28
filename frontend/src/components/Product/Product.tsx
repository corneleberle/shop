import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import {CardActionArea, Grid} from '@mui/material';
import {Product as ProductType} from '@/__generated__/graphql';
import dummy_image from './dummy.png'

export default function Product({product}: { product: ProductType }) {
  return (
      <Grid item key={product.id}>
        <Card sx={{maxWidth: 345}}>
          <CardActionArea>
            <CardMedia
                component="img"
                height="140"
                image={dummy_image.src}
                alt="green iguana"
                sx={{objectFit: 'contain'}}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                {product.name}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Lizards are a widespread group of squamate reptiles, with over 6,000
                species, ranging across all continents except Antarctica
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </Grid>
  );
}
