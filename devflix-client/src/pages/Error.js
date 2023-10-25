import { useNavigate } from "react-router-dom";

export default function Error({ msg }) {
  const navigate = useNavigate();

  return (
    <p>
      🙅🏾‍♂️ Error{" "}
      {navigate.location.state ? ` - ${navigate.location.state.msg}` : ""}
      {msg}
    </p>
  );
}