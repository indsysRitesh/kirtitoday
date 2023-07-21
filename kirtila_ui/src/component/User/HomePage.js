/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useEffect,useState } from 'react'
import Footer from './Footer'
import Header from './Header'

import axios from 'axios'



const HomePage = () => {
    // const [allProduct, SetProduct] = React.useState([]);

    // useEffect(() => {
    //     axios.get("https://fakestoreapi.com/products")
    //         .then(response => response.data)
    //         .then(res => {
    //             console.log(res)
    //             SetProduct(res)
    //         })
    // }, [])




    // addcard/
    const [allProduct, setProduct] = useState([]);
    const [cartItems, setCartItems] = useState([]);
    // const [editedItem, setEditedItem] = useState(null);
  
    useEffect(() => {
      axios.get('https://fakestoreapi.com/products')
        .then(response => {
          console.log(response.data);
          setProduct(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    }, []);
  
    const handleAddToCart = (product) => {
      setCartItems([...cartItems, product]);
    };
  
    // const handleDeleteCartItem = (index) => {
    //   const updatedCartItems = [...cartItems];
    //   updatedCartItems.splice(index, 1);
    //   setCartItems(updatedCartItems);
    // };
  
    // const handleUpdateCartItem = (index, item) => {
    //   setEditedItem({ index, item });
    // };
  
    // const handleSaveEditedItem = (index, updatedItem) => {
    //   const updatedCartItems = [...cartItems];
    //   updatedCartItems[index] = updatedItem;
    //   setCartItems(updatedCartItems);
    //   setEditedItem(null);
    // };
  
    // const handleCancelEdit = () => {
    //   setEditedItem(null);
    // };
  








    return (
        <div id='user'>
            <Header />
            <div className="hot-deal-banner">
                <div className="container">
                    <div className="bg">
                        <div className="row">
                            <div className="col-lg-7">
                                <div className="banner-txt">
                                    <h2><span>Hot deal</span> this week</h2>
                                    <p>Tables & Chairs up to 30% off</p>
                                    <div id="hotDealCountdown" className="countdown"></div>
                                    <a href="shop-details.html" className="def-btn">Shop Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <div className="flash-deal">
                <div className="container">
                    <div className="panel">
                        <div className="panel-header">
                            <div className="row align-items-center">
                                <div className="col-lg-2 col-md-2 col-6">
                                    <h2 className="title">Flash Deal!</h2>
                                </div>
                                <div className="col-lg-8 col-md-8 countdown-col">
                                    <div className="countdown-wrap d-flex">
                                        <h3>Ending Soon...</h3>
                                        <div id="flashDealCountdown" className="countdown"></div>
                                    </div>
                                </div>
                                <div className="col-lg-2 col-md-2 col-6">
                                    <div className="text-end">
                                        <a href="shop.html" className="explore-section">View more</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="panel-body">

                            <div className="product-custom-row">
                                <div className='product-custom-row '>
                                  
                            {allProduct.map((display, ind) => (
                            <div className="custom-col ">
                            <div className="single-product-card">
                                <div className="part-img">
                                    <span className="off-tag">15%</span>
                                    <a href="shop-details.html"><img className='w-50 h-50 ' src={display.image} alt="Product"/></a>
                                    <div className="cart-option cart-option-bottom">
                                        <ul>
                                            <li>
                                                {/* <a role="button" className="add-to-cart">
                                                    <i className="fa-light fa-cart-shopping"></i>
                                                </a> */}
                                                  <a role="button" className="add-to-cart" 
                                                  onClick={() => handleAddToCart(display)}>
                                                    <i className="fa-light fa-cart-shopping"></i></a>
                          
                                            </li>
                                            <li>
                                                <a role="button" className="add-to-wish">
                                                    <i className="fa-light fa-heart"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a role="button" className="quick-view">
                                                    <i className="fa-light fa-image"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="shop-details.html" className="view-product">
                                                    <i className="fa-light fa-eye"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="part-txt">
                                    <h4 className="product-name"><a href="shop-details.html">{display.title}</a></h4>
                                    <p className="price"><span>{display.price}</span>$75.00</p>
                                    <div className="star">
                                        <i className="fa-solid fa-star-sharp rated"></i>
                                        <i className="fa-solid fa-star-sharp rated"></i>
                                        <i className="fa-solid fa-star-sharp rated"></i>
                                        <i className="fa-solid fa-star-sharp rated"></i>
                                        <i className="fa-solid fa-star-sharp"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        ))}
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            
            <Footer />
        </div>
    )
}

export default HomePage


