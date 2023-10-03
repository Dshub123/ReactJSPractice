import React from "react";

const Footer = () => {

  const STYLE = {
    footer: {
      position: 'absolute',
      bottom: '0',
      width: '100%',
      height: '40px',
      backgroundColor: 'bague',
    }
  };

  return (
    <footer className="footer" style={STYLE.footer}>
      <span className="text-muted">@ShubhamDiddi</span>
    </footer>
  );
};

export default Footer;