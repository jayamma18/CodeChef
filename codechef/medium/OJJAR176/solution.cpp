function LinkButton({ href, children, className, ...props }) {
  const Tag = typeof href === "string" ? "a" : "button";

  return (
    <Tag
      href={href}
      className={className}
      {...props}
    >
      {children}
    </Tag>
  );
}

export default LinkButton;
